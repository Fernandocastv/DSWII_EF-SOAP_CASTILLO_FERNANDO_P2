package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class MiembroWsdlConfig {

    @Bean(name = "miembros")
    public DefaultWsdl11Definition bibliotecaWsdl11Definition(XsdSchema miembrosEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("MiembrosPort");
        wsdl11Definition.setLocationUri("/ws/miembros");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/object");
        wsdl11Definition.setSchema(miembrosEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema miembrosEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/miembro.xsd"));
    }
}
