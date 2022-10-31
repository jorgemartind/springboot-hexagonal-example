# springboot-hexagonal-example
Example java spring boot application with hexagonal architecture

## TODO
- [ ] Refactor and modularize application folder
- [ ] Modify all groupid of poms
- [ ] Add postman collections
- [ ] Add dependency manager to parent pom
- [ ] Change Rate price from double to BigDecimal
- [ ] Add api version
- [ ] Improve documentation
- [ ] Add more unit tests

## RUN
```console
docker-compose up
```
## TEST
GET http://localhost:8080/rates?productId=1&brandId=1&date=2022-01-01