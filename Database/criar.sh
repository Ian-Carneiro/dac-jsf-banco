docker build -t dac/postgres .
docker run -p 5433:5432 --name db -d dac/postgres