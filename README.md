# category


## Project Structure

Node is required for generation and recommended for development. `package.json` is always generated for a better development experience with prettier, commit hooks, scripts and so on.

In the project root, JHipster generates configuration files for tools like git, prettier, eslint, husky, and others that are well known and you can find references in the web.

`/src/*` structure follows default Java structure.

- `/src/main/docker` - Docker configurations for the application and services that the application depends on

## Development

To start your application in the dev profile, run:

```
./mvnw
```

### JHipster Control Center

JHipster Control Center can help you manage and control your application(s). You can start a local control center server (accessible on http://localhost:7419) with:

```
docker compose -f src/main/docker/jhipster-control-center.yml up
```

### Doing API-First development using openapi-generator-cli

[OpenAPI-Generator]() is configured for this application. You can generate API code from the `src/main/resources/swagger/api.yml` definition file by running:

```bash
./mvnw generate-sources
```

Then implements the generated delegate classes with `@Service` classes.

To edit the `api.yml` definition file, you can use a tool such as [Swagger-Editor](). Start a local instance of the swagger-editor using docker by running: `docker compose -f src/main/docker/swagger-editor.yml up -d`. The editor will then be reachable at [http://localhost:7742](http://localhost:7742).

Refer to [Doing API-First development][] for more details.

## Building for production

### Packaging as jar

To build the final jar and optimize the category application for production, run:

```
./mvnw -Pprod clean verify
```

To ensure everything worked, run:

```
java -jar target/*.jar
```

Refer to [Using in production][] for more details.

### Packaging as war

To package your application as a war in order to deploy it to an application server, run:

```
./mvnw -Pprod,war clean verify
```

## Testing

To launch your application's tests, run:

```
./mvnw verify
```

### Other tests

Performance tests are run by [Gatling][] and written in Scala. They're located in [src/test/java/gatling/simulations](src/test/java/gatling/simulations).

You can execute all Gatling tests with

```
./mvnw gatling:test
```

For more information, refer to the [Running tests page][].

### Code quality

Sonar is used to analyse code quality. You can start a local Sonar server (accessible on http://localhost:9001) with:

```
docker compose -f src/main/docker/sonar.yml up -d
```

Note: we have turned off forced authentication redirect for UI in [src/main/docker/sonar.yml](src/main/docker/sonar.yml) for out of the box experience while trying out SonarQube, for real use cases turn it back on.

You can run a Sonar analysis with using the [sonar-scanner](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner) or by using the maven plugin.

Then, run a Sonar analysis:

```
./mvnw -Pprod clean verify sonar:sonar -Dsonar.login=admin -Dsonar.password=admin
```

If you need to re-run the Sonar phase, please be sure to specify at least the `initialize` phase since Sonar properties are loaded from the sonar-project.properties file.

```
./mvnw initialize sonar:sonar -Dsonar.login=admin -Dsonar.password=admin
```

Additionally, Instead of passing `sonar.password` and `sonar.login` as CLI arguments, these parameters can be configured from [sonar-project.properties](sonar-project.properties) as shown below:

```
sonar.login=admin
sonar.password=admin
```

For more information, refer to the [Code quality page][].

## Using Docker to simplify development (optional)

You can use Docker to improve your development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a mysql database in a docker container, run:

```
docker compose -f src/main/docker/mysql.yml up -d
```

To stop it and remove the container, run:

```
docker compose -f src/main/docker/mysql.yml down
```

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

```
npm run java:docker
```

Or build a arm64 docker image when using an arm64 processor os like MacOS with M1 processor family running:

```
npm run java:docker:arm64
```

Then run:

```
docker compose -f src/main/docker/app.yml up -d
```

When running Docker Desktop on MacOS Big Sur or later, consider enabling experimental `Use the new Virtualization framework` for better processing performance ([disk access performance is worse](https://github.com/docker/roadmap/issues/7)).

For more information refer to [Using Docker and Docker-Compose][], this page also contains information on the docker-compose sub-generator (`jhipster docker-compose`), which is able to generate docker configurations for one or several JHipster applications.

## Continuous Integration (optional)

To configure CI for your project, run the ci-cd sub-generator (`jhipster ci-cd`), this will let you generate configuration files for a number of Continuous Integration systems.

[JHipster Homepage and latest documentation]: https://www.jhipster.tech
[JHipster 8.0.0-beta.1 archive]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1
[Doing microservices with JHipster]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1/microservices-architecture/
[Using JHipster in development]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1/development/
[Service Discovery and Configuration with Consul]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1/microservices-architecture/#consul
[Using Docker and Docker-Compose]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1/docker-compose
[Using JHipster in production]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1/production/
[Running tests page]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1/running-tests/
[Code quality page]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1/code-quality/
[Setting up Continuous Integration]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1/setting-up-ci/
[Node.js]: https://nodejs.org/
[NPM]: https://www.npmjs.com/
[Gatling]: https://gatling.io/
[OpenAPI-Generator]: https://openapi-generator.tech
[Swagger-Editor]: https://editor.swagger.io
[Doing API-First development]: https://www.jhipster.tech/documentation-archive/v8.0.0-beta.1/doing-api-first-development/
# category_service