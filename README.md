# Turkcell-Bootcamp-e-commerce-

Turkcell homework 2 Bir E-ticaret sistemi oluşturmak istiyoruz. Spring Boot 3.0.4, paket yöneticisi olarak Maven ve Java SDK olarak 17 veya daha üst bir versiyon kullanılacaktır. (Sadece Spring Web ve Swagger bağımlılığını eklemeniz yeterli olacaktır.)

Proje ismi : e-commerce

Req 1 : Sistemde Ürünler(Product) tutulmalıdır.

Req 2 : Ürünün id,name,quantity,price ve description şeklinde özellikleri olacaktır.

Req 3 : Ürünleri ekleyebilecek, silebilecek, güncelleyebilecek, listeleyebilecek, id ile getirebilecek kodları yazınız. Bunu tamamen in memory yapınız.

Req 4 : Ürünlerin fiyat bilgisi 0 dan büyük olmalıdır.

Req 5 : Ürünlerin quantity(miktarı) 0 dan küçük olamaz.

Req 6 : Ürünlerin description(açıklama) alanı min 10 karakter max 50 karakter olmalıdır.

---- (Validation paketini kullanmadan, kod yazarak algoritmik çözünüz) ----

Projede derste gördüğümüz gibi katmanlı mimari kullanılacaktır. Kodlarınızı github'a yükleyiniz. Zorlandığınız veya yapamadığınız kısımlarda diğer arkadaşlarınızdan yardım alınız.

NOT : Belirtilen 6 madde dışında herhangi bir ekleme yada süsleme yapmayınız!

![image](https://user-images.githubusercontent.com/113211889/229170596-79ba2979-acdf-475b-a688-0b4667cb74d8.png)

## <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.0.4</version>
		</dependency>
        <dependency>
            <groupId>org.modelmapper</groupId>
            <artifactId>modelmapper</artifactId>
            <version>3.1.1</version>
            <scope>compile</scope>
        </dependency>
		<dependency>
			<groupId>org.modelmapper</groupId>
			<artifactId>modelmapper</artifactId>
			<version>3.1.1</version>
			<scope>compile</scope>
		</dependency>
        <dependency>
            <groupId>kodlama.io</groupId>
            <artifactId>rent-a-car</artifactId>
            <version>0.0.1-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>


