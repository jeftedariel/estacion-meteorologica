// Codigo para el segundo transmisor.

//Librerias para LoRa
#include <LoRa.h>
#include <SPI.h>

//Libraries para comunicar con y dibujar en la pantalla OLED integrada
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>

Adafruit_BME280 bme

//Debemos definir los pines que se utilizaran por el modulo LoRa
#define SCK 5
#define MISO 19
#define MOSI 27
#define SS 18
#define RST 14
#define DIO0 26

//Aqui definimos una frecuencia de operacion, aqui es la de America
#define BAND 915E6

//Definimos los pines necesarios para conectar con pantalla OLED
#define ANCHOPANTALLA 128 // El ancho de la pantalla en pixeles es de 128px
#define ALTOPANTALLA 64 // El ancho de la pantalla en pixeles es de 64px
#define OLED_SDA 4
#define OLED_SCL 15 
#define OLED_RST 16

double datos[3][3];

Adafruit_SSD1306 display(ANCHOPANTALLA, ALTOPANTALLA, &Wire, OLED_RST);

void setup() {
  
  Serial.begin(115200);//inicia monitor serial

  pinMode(OLED_RST, OUTPUT);//reseteamos la pantalla OLED para comenzar
  digitalWrite(OLED_RST, LOW);
  delay(20);
  digitalWrite(OLED_RST, HIGH);

  Wire.begin(OLED_SDA, OLED_SCL); //inicia OLED
  if(!display.begin(SSD1306_SWITCHCAPVCC, 0x3c, `false, false)) { // 0x3C representa 128x32
    Serial.println(F("Fallo iniciando SSD1306"));
    for(;;); // Si detecta el fallo anterior, se detiene hasta que se reinicie
  }
  
  display.clearDisplay();//Borramos pantalla
  display.setTextColor(WHITE);//Definimos texto color blanco
  display.setTextSize(1);//TamaÃ±o de fuente a 1 punto
  display.setCursor(0,0);//Comenzamos a graficar desde coordenadas 0,0
  display.print("TRANSMISOR LORA ");
  display.display();
  
  Serial.println("Prueba de envÃ­o LoRa");

  SPI.begin(SCK, MISO, MOSI, SS);  //Definimos pines SPI
  LoRa.setPins(SS, RST, DIO0); //Configuramos el LoRa para enviar
  
  if (!LoRa.begin(BAND)) {//Intenta transmitir en la banda elegida
    Serial.println("Error iniciando LoRa");//Si no puede transmitir, marca error
    while (1);
  }
  Serial.println("Inicio exitoso de LoRa!");//Mensaje de todo bien en puerto serial
  display.setCursor(0,10);
  display.print("Inicio exitoso de LoRa!");//Mensaje de todo bien en pantalla OLED
  display.display();
  delay(2000);//Esperamos un par de segundos

  for(int i = 0; i<3; i++){
    for(int k = 0; k<3; i++){
      datos[i][k] = 0;
    }
  }
}
void loop() {
  int tamanoPaquete = LoRa.parsePacket();  //analizamos paquete
  if (tamanoPaquete) {//Si nos llega paquete de datos
    Serial.print("Paquete recibido ");//Muestra confirmacion

    while (LoRa.available()) {//Leemos el paquete
      DatoLoRa = LoRa.readString();//Guardamos cadena en variable
      Serial.print(DatoLoRa);//Lo imprimimos en monitor serial
    }

    int rssi = LoRa.packetRssi();//Esto nos imprime la intensidad de seÃ±al recibida
    Serial.print(" Señal: ");    
    Serial.println(rssi);

  while ( j < DatoLoRa.length()){
    for(int n = 0; i<3; i++){
      for(int k = 0; k<3; i++){
      
        string dato;
        if (DatoLoRa.charAt(j) == ','){
          i++;
      }else{
        dato = dato + DatoLoRa.charAt(j);
      }
      datos[n][k] = dato;
    }
   }
  }

   // Mostramos informacion captada
   display.clearDisplay();
   display.setCursor(0,0);
   display.print("Receptor LoRa");//Mensaje
   display.setCursor(0,20);
   display.print("Paquete recibido:");//Imprime datos recibidos
   display.setCursor(0,30);
   display.print(DatoLoRa);
   display.setCursor(0,40);
   display.print("RSSI:");//Imprime intensidad de seÃ±al
   display.setCursor(30,40);
   display.print(rssi);
   display.display();   
  }
  
  datos[2][0] = bme.readTemperature();
  datos[2][1] = bme.readHumidity();
  datos[2][2] = bme.readPressure() / 100.0F; 

  Serial.print("Enviando paquete: ");//Muestra mensaje
  Serial.println(datos);//Muestra la cuenta actual


  //Para mandar paquete al LoRa receptor
  LoRa.beginPacket();//Inicia protocolo
  LoRa.print(datos);
  LoRa.endPacket();//Fin de paquete enviado
  
  display.clearDisplay();//Limpia pantalla
  display.setCursor(0,0);//Posicionamos en siguiente renglÃ³n
  display.setTextSize(1);//TamaÃ±o de fuente a 1 punto
  display.println("Transmisor LoRa");// 
  display.setCursor(0,30);
  display.print("Paquete LoRa enviado.");//Mensaje de confirmaciÃ³n
  display.setCursor(0,50);
  display.print(" Datos:");//Mensaje
  display.setCursor(80,50);
  display.print( datos);
  display.display();
  
  delay(1000);
}

