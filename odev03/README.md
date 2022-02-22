##  170. Hepsiemlak Java Spring Bootcamp

###### Tacettin Utku Süer



#### Ödev 3



##### • EmlakBurada-Banner uygulamasına Spring feign client kullanarak da client oluşturun.



Aşağıda main servisi üzerinden (localhost:8083) request ataması yapılmaktadır. Bir sonraki resimde ise bu Requestin banner servisinde GEt ile görüntülemesi yer almaktadır.



![feignClientPost](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/feignClientPost.PNG?raw=true)



Aşağıda hem Rest hem de feign client ile yapılmış olan POSTların banner servisi (localhost:8081)'de ki Response'ları görülmektedir.

![feign client](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/FeignClient.PNG?raw=true)



##### • EmlakBurada uygulaması ActiveMQ da kullanarak veri gönderimini sağlayın.



Aşağıda main servisi üzerinden ActiveMQ'ya gönderilmiş olan isteğin ActiveMQ üzerinde queue olarak görüntülenmesi yer almaktadır.



![ActiveMQ.PNG](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/ActiveMQ.PNG?raw=true)



Aşağıda da email servisi üzerindeki Listener kodları sayesinde ActiveMQ queue'leri okunup program içerisinden mail atılmıştır. Gmail güvenlik yönetmeliklerinden dolayı ERROR gözükmektdir fakat ActiveMQ kullanılarak e-mail atma isteği gönderilmiş olmaktadır. Queue listesinde emlakburada.queue definition'nda görüldüğü üzere beklemede (pending) mesaj yoktur, çünkü email servisi queue'ları karşılamış ve bekleyen mesaj bırakmamıştır.



![ActiveMQ](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/ActiveMQ-mail.PNG?raw=true)



##### • EmlakBurada uygulamasında eksik kalan KullanıcınıService ve MessageService katmanlarının Controller katmanını yazın. Aşağıdaki işlemleri yapıyor olması gerek.


Ödev klasörü içerisinde bu katmanların kodları yer almaktadır. create, findAll ve findOne metodlarının kullanılmasına dair postman üzerinden alınmış ekran görüntüleri aşağıda yer almaktadır.



##### 		- User Servisinin ekran görüntüleri,

###### GET: localhost:8083/users

![](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/userGet.PNG?raw=true)



###### POST: localhost:8083/users

![](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/userPost.PNG?raw=true)



###### GET: localhost:8083/users/2

![](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/UserGetFilter.PNG?raw=true)


##### 		- User Servisinin ekran görüntüleri,

###### GET: localhost:8083/messages

![](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/mesajGet.PNG?raw=true)



###### POST: localhost:8083/messages

![](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/mesajPost.PNG?raw=true)



###### GET: localhost:8083/messages/3

![](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/mesajGetFilter.PNG?raw=true)



##### • EmlakBurada uygulamasında IlanController içerisinde id’si verilen kullanıcının favori ilanlarını getiren yeni bir method yazın.



localhost:8083/advertsByUserId/? soru işaretli olan yere kullanıcı id numarası girilmiş kişinin favori ilanlarının başlıklarını getirmektedir. Aşağıda da örnek bir uygulamanın ekran görüntüsü yer almaktadır.



![](https://github.com/Hepsiemlak-Java-Spring-Bootcamp/hepsiemlak-java-spring-bootcamp-hw3-TacettinUtkuSuer/blob/main/odev03/Sekiller/userId2favoriIlanlar.PNG?raw=true)


