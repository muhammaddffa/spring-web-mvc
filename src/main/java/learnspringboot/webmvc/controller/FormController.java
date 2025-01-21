package learnspringboot.webmvc.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    @PostMapping(
            path = "/form/hello",
            //Untuk Menerima data jenis apa
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            //Untuk Membuat data untuk membuat apa
            produces = MediaType.TEXT_HTML_VALUE
    )
    @ResponseBody
    public String hello(@RequestParam(name = "name") String name){
        return """
                <html>
                <body>
                <h1>Hello $name</h1>
                <body>
                <html>
                """.replace("$name", name);
    }

}
