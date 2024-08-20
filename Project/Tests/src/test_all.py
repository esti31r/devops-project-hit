import requests
import pytest
import logging

# Assuming the API URL is as follows:
BASE_URL = "http://localhost:8090/api/jobs"

def configure_logging():
    # Create logger
    logger = logging.getLogger('my_application_logger')
    logger.setLevel(logging.DEBUG)  # Set the logging level (DEBUG, INFO, WARNING, ERROR, CRITICAL)

    # Create file handler which logs even debug messages
    fh = logging.FileHandler('my_application.log')
    fh.setLevel(logging.DEBUG)  # You can set a different level if you only want to log errors to file

    # Create formatter and add it to the handler
    formatter = logging.Formatter('%(asctime)s - %(levelname)s - %(message)s')
    fh.setFormatter(formatter)

    # Add the handler to the logger
    logger.addHandler(fh)

    return logger

def logger(response):
    LOGGER = configure_logging()
    msg = f"""
    Response Status: {response.status_code}
    Body: {response.text}
    """
    LOGGER.info(msg)
    

@pytest.fixture(scope="module")
def client():
    with requests.Session() as session:
        yield session

# Test: Retrieve All CI/CD Jobs
def test_get_all_jobs(client):
    response = client.get(BASE_URL)
    logger(response)
    assert response.status_code == 200
    assert isinstance(response.json(), list), "Response should be a list of jobs"

# Test: Create a New CI/CD Job
def test_create_job(client):
    job_data = {"jobName": "New Deployment", "status": "pending", "jobType": "Build"}
    response = client.post(BASE_URL, json=job_data)
    logger(response)
    assert response.status_code == 201
    response_data = response.json()
    assert response_data["jobName"] == job_data["jobName"], "Job name should match the submitted name"
    assert response_data["status"] == job_data["status"], "Job status should be 'pending'"
    assert "id" in response_data, "Response should include an auto-generated id"
    assert "createdAt" in response_data, "Response should include the auto-set createdAt field"

# Test: Retrieve a Specific CI/CD Job by ID
def test_get_job_by_id(client):
    job_id = 1  # Example job ID, assuming it exists
    response = client.get(f"{BASE_URL}/{job_id}")
    logger(response)
    assert response.status_code == 200
    response_data = response.json()
    assert response_data['id'] == job_id, "Job ID should match the requested ID"
    assert "jobName" in response_data, "Response should include jobName"

# Test: Update the Status and Type of a CI/CD Job
def test_update_job_status_and_type(client):
    job_id = 1  # Example job ID, assuming it exists
    updated_data = {"id": job_id, "status": "completed", "jobType": "Deployment", "jobName":"job 2"}
    response = client.patch(f"{BASE_URL}/{job_id}", json=updated_data)
    logger(response)
    assert response.status_code == 204

# Test: Delete a CI/CD Job
def test_delete_job(client):
    job_id = 1  # Example job ID, assuming it exists
    response = client.delete(f"{BASE_URL}/{job_id}")
    logger(response)
    assert response.status_code == 204, "Response should be 204 No Content after job deletion"