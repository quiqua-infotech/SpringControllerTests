In our [previous blog](https://medium.com/blog-quiqua/https-medium-com-blog-quiqua-unit-testing-your-api-controllers-879dbf01796f "previous blog") we talked about how unit testing the API controllers could be beneficial. We followed it up with a [code walkthrough](https://medium.com/blog-quiqua/unit-testing-your-api-controllers-a-code-walkthrough-44439728e0fa "code walkthrough"). 
This project tries to show how you can write unit tests for controllers using spring's @webMvcTest annotation. 
To run the project in debug mode, run this from root : 
`mvn spring-boot:run -Dagentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005`

To execute the tests, run this from root :

`mvn test`
