call ./gradlew clean
call ./gradlew bootJar

call docker network create standalone_pg
call docker volume create pgdata

call docker run --name crud-example-pg ^
	--network=standalone_pg ^
	-p 5432:5432 ^
	-e POSTGRES_USER=root ^
	-e POSTGRES_PASSWORD=root ^
	-e POSTGRES_DB=paste ^
	-v pgdata:/var/lib/postgresql/data ^
	-d postgres

call docker run --name crud-example-pgadmin4 ^
	--network=standalone_pg ^
	-p 3000:3000 ^
	-e PGADMIN_DEFAULT_EMAIL=admin@mail.com ^
	-e PGADMIN_DEFAULT_PASSWORD=root ^
	-d dpage/pgadmin4


call docker build -t paste .

call docker run -p 8081:8080 ^
    --network=standalone_pg ^
    --name CrudExampleWithDocker ^
    -d paste
