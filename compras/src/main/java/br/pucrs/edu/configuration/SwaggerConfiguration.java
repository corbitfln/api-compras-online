package br.pucrs.edu.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.pucrs.edu"))
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo())

                .globalResponseMessage(RequestMethod.GET,
                        Arrays.asList(
                                new ResponseMessageBuilder()
                                        .code(500)
                                        .message("Erro interno no servidor.")
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(403)
                                        .message("Forbidden! Você não pode acessar esse recurso.")
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(404)
                                        .message("O recurso não foi encontrado.")
                                        .build()));

    }
	
    private ApiInfo apiInfo() {
        Contact contato = new Contact("PUC-RS Online",
                "https://https://online.pucrs.br/", "rogerio.ribeiro90@edu.pucrs.br");

        return new ApiInfoBuilder()
                .title("API Compras Online")
                .description("Documentação interativa da Rest API Requerimento Compensação. Tente enviar algum request ;)")
                .version("1.0")
                .contact(contato)
                .build();
    }    
    
    
}
