package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class LibroWsdlConfig {

    @Bean(name = "libros")
    public DefaultWsdl11Definition bibliotecaWsdl11Definition(XsdSchema librosEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("LibrosPort");
        wsdl11Definition.setLocationUri("/ws/libros");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/object");
        wsdl11Definition.setSchema(librosEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema librosEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/libro.xsd"));
    }
}
