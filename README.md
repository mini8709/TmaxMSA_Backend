# TmaxMSA_Backend

## 핵사고날 아키텍처에 기반한 패키지 구조


- adapter 하위에 web에는 주 어댑터, persistence에는 부 어댑터를 둠
- application 하위에 주 포트를 두고, impl에 주 포트 구현체, spi에 부 포트를 둠 
- domain 하위에 비지니스 로직을 둠
- 입출력 dto는 해당 dto를 사용하는 서비스와 함께 둠
- [이 프로젝트](https://github.com/CAUCSE/CAUSW_backend) 가 핵사고날 아키텍처 형태로 패키지를 구성하였으니 참고하세요.
  

```

com.msa.server
    |
    |-- adapter
    |    |-- web
    |    |    `-- ExampleController.java
    |    |      
    |    `-- persistence
    |         |-- ExampleRepository.java
    |         |-- Example.java 
    |         `-- ExamplePortImpl.java 
    |
    |-- application
    |    |-- spi
    |    |    `-- ExamplePort.java
    |    | 
    |    |-- dto
    |    |    `-- ExampleDto.java
    |    | 
    |    `-- ExampleService.java
    |
    `-- domain
         `-- exception
   
```