# Spring Sandbox

An introductory project working on integrating [Spring Boot] framework with
[Hibernate] and a small play around with [Docker] for the usage of the database.

The service is a REST service providing a basic CRUD API for working with
_Employees_ in a database.

The database used is [PostgreSQL] with the commands to recreate the database in
the `migrations` directory. (These are created using [Diesel CLI](http://diesel.rs/))

[Spring Boot]: https://projects.spring.io/spring-boot/
[Hibernate]: http://hibernate.org/orm/
[Docker]: https://www.docker.com/
[PostgreSQL]: https://www.postgresql.org

## Usage

### Start Database

```shell
$ cd docker
$ docker-compose up
```

Then apply `migrations/2018-4-4/up.sql` followed by
`migrations/2018-4-4/alter.sql` in whichever preferred method you have. If you
have Diesel CLI just use `diesel migration run`.

### Start REST service

```shell
$ ./gradlew bootRun
```