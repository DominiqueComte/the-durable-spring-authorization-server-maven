# the-durable-spring-authorization-server

Hi, Spring fans! In this installment, we're going to look at how to set up a durable, secure, scalable, restartable,
load-balanceable Spring Authorization Server.

See YouTube recording on https://www.youtube.com/watch?v=wq7oU2UCsbo

## Running

* Start Docker
* run `docker compose up -d`
* run `auth-server/run.sh`
* run `api/run.sh`
* run `processor/run.sh`
* run `static/run.sh`
* run `gateway/run.sh`

Open http://127.0.0.1:8082/
