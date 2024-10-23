package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class CategoriaWsdlConfig {

    @Bean(name = "categorias")
    public DefaultWsdl11Definition bibliotecaWsdl11Definition(XsdSchema categoriasEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CategoriasPort");
        wsdl11Definition.setLocationUri("/ws/categorias");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/object");
        wsdl11Definition.setSchema(categoriasEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema categoriasEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/categoria.xsd"));
    }
}
