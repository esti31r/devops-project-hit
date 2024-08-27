FROM python:3.9-slim
WORKDIR /app
COPY requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt
COPY ../Tests ./Tests 
CMD ["pytest", "Tests/src/test_all.py"]
