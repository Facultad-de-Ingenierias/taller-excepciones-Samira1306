package exceptions;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

//Trabaje con Juan Esteban Bustos
// No tenía definida las excepciones que tenía que mandar
public class Instanciacion {
    public Object crearObjeto() throws InstantiationException, IllegalAccessException {
        Class<?> clase = this.getClass();
        return clase.newInstance();
    }

    public static void main(java.lang.String[] args) {
        Instanciacion creador = new Instanciacion();
        try {
            Object creado = creador.crearObjeto();
            System.out.println(creado);
        } catch (InstantiationException | IllegalAccessException errorCrea) {
            System.out.println("No se pudo crear el objeto");
        }
    }

    /* 2. Usted debe escribir un método que calcula el valor que debe pagar una persona por boletas de
    cine, lo cual depende de la cantidad de boletas que lleva. Si dentro del método encuentra que la
    cantidad de boletas no está dentro de los rangos establecidos, ¿debería lanzar una excepción o
    retornar cero? En caso de lanzar una excepción, ¿sería comprobada o no comprobada? Explique
    brevemente sus respuestas. 
    
    R= El metodo lanza una exceptción comprobada porque la cantidad de boletas que le entrán al código no 
    tiene nada que ver con el mimso, es algo que no se puede manejar desde el código
    */

    /* 3. Usted debe escribir un método que consulta las materias que tiene inscritas un estudiante, a partir
    del código del estudiante. Si el estudiante no tiene materias inscritas, ¿debería lanzar una
    excepción o retornar una lista vacía? En caso de lanzar una excepción, ¿sería comprobada o no
    comprobada? Explique brevemente sus respuestas.
    
    R= el metodo si retorna una exceptcioón dado que es una mala practica retorna la lista vacía. 
    */

    /* 4. Se desea un programa que pida al usuario una URL y verifique si el contenido (Content Type) es
    de tipo texto (text/plain). Si es de tipo texto se debe mostrar este contenido. En caso contrario se
    muestra al usuario de qué tipo es el contendido. Además, en caso de que la URL tenga algún
    error o que no se pueda obtener el contenido se debe mostrar un mensaje explicando cuál es el
    error. Se deben usar las clases java.net.URL y java.net.URLConnection. 
     */

     public void url(String url) throws Exception{
        try{
        URL urlFinal = new URL(url);
        HttpsURLConnection  connection = (HttpsURLConnection) urlFinal.openConnection();
       // connection.setRequestMethod(method: "HEAD");
        connection.connect();
        System.out.println(connection.getContentType());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

     /*5. Escriba el código en Java de un método llamado “calcularIva”, que recibe el precio de un producto
    (double) y el tipo de producto (String). Este método calcula el valor del IVA de la siguiente forma:
    es el 19 % para la mayoría de los productos, excepto para los de tipo básico, donde es el 10 % y
    los de tipo cultural, donde es 0 %.
    Realice algunas pruebas para verificar el funcionamiento del método, y tenga en cuenta las
    posibles validaciones que se deben realizar (considere si es pertinente o no usar una excepción).
      */

      public static double calcularIva(double precio, String tipo){
        double iva=0;
        try {
        if(tipo == "basico"){
            iva= precio*0.1;
        }else if(tipo == "cultural"){
            iva=0;
        }else{
            iva=precio*0.19;
        }
        return  iva;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }
}
