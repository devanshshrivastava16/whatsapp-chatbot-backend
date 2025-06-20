# 🤖 WhatsApp Chatbot Backend using Java & Spring Boot

![WhatsApp Chatbot Banner](https://img.shields.io/badge/WhatsApp-Chatbot-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)
![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)

This project implements a backend chatbot service using **Java**, **Spring Boot**, **Firebase**, and the **Meta WhatsApp Cloud API**. It enables automated interaction with WhatsApp users via structured messaging and webhook communication.

---

## 📌 Features

- ✅ Receive and process WhatsApp messages via webhooks
- ✅ Auto-reply to users using WhatsApp Cloud API
- ✅ Integrate with **Firebase** for storage (e.g., chat logs)
- ✅ Secure credential handling (`serviceAccountKey.json`)
- ✅ Deployable on platforms like **Render**

---

## 🚀 Tech Stack

| Technology     | Purpose                           | Badge |
|----------------|-----------------------------------|-------|
| Java 17+       | Core language                     | ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white) |
| Spring Boot    | Backend framework                 | ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=spring&logoColor=white) |
| Firebase Admin SDK | Chat storage / user logs       | ![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=flat&logo=firebase&logoColor=black) |
| WhatsApp Cloud API | Send/receive WhatsApp messages | ![WhatsApp](https://img.shields.io/badge/WhatsApp-25D366?style=flat&logo=whatsapp&logoColor=white) |
| Render / ngrok | Deployment / local webhook testing | ![Render](https://img.shields.io/badge/Render-46E3B7?style=flat&logo=render&logoColor=white) |

---

## 🏗️ Project Structure

```
whatsapp-chatbot-backend/
├── controller/
│   └── WhatsAppWebhookController.java
├── service/
│   ├── WhatsAppService.java
│   └── FirebaseInitializer.java
├── model/
│   └── Message.java
├── resources/
│   ├── application.properties
│   └── serviceAccountKey.json  # 🚫 IGNORED
├── WhatsappChatbotApplication.java
├── pom.xml
└── README.md
```

---

## 🛠️ Setup Instructions

### 1. Clone the repo

```bash
git clone https://github.com/yourusername/whatsapp-chatbot-backend.git
cd whatsapp-chatbot-backend
```

### 2. Add Firebase service account key

![Firebase Console](https://img.shields.io/badge/Firebase-Console-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)

- Go to [Firebase Console](https://console.firebase.google.com/)
- Navigate to **Project Settings > Service Accounts**  
  ![Firebase Settings](https://img.shields.io/badge/Settings-Service%20Accounts-orange?style=flat)
- Click **Generate new private key**  
  ![Generate Key](https://img.shields.io/badge/Action-Generate%20Key-green?style=flat)
- Save the downloaded `serviceAccountKey.json` in `src/main/resources/`

### 3. Configure application properties

```properties
server.port=8080

whatsapp.phone.number.id=YOUR_PHONE_NUMBER_ID
whatsapp.access.token=YOUR_TEMP_ACCESS_TOKEN
firebase.config.path=classpath:serviceAccountKey.json
```

### 4. Start the server

```bash
./mvnw spring-boot:run
```

![Server Running](https://img.shields.io/badge/Status-Server%20Running-brightgreen?style=flat&logo=spring)

### 5. Expose webhook for WhatsApp (if local)

```bash
ngrok http 8080
```

![ngrok](https://img.shields.io/badge/ngrok-Tunnel%20Active-blue?style=flat&logo=ngrok)

Use the generated URL to set up webhook in Meta Developer Console.

---

## ✅ WhatsApp Webhook Setup (Cloud API Sandbox)

![Meta Developers](https://img.shields.io/badge/Meta-Developers-1877F2?style=for-the-badge&logo=meta&logoColor=white)

1. Go to [Meta for Developers](https://developers.facebook.com)  
   ![Step 1](https://img.shields.io/badge/Step%201-Create%20Account-blue?style=flat)

2. Create a **Business App**  
   ![Step 2](https://img.shields.io/badge/Step%202-Business%20App-orange?style=flat)

3. Add the **WhatsApp product**  
   ![Step 3](https://img.shields.io/badge/Step%203-Add%20WhatsApp-25D366?style=flat&logo=whatsapp)

4. Link a test phone number  
   ![Step 4](https://img.shields.io/badge/Step%204-Link%20Phone-yellow?style=flat)

5. Register your webhook (e.g., `https://xyz.ngrok.io/webhook`)  
   ![Step 5](https://img.shields.io/badge/Step%205-Register%20Webhook-purple?style=flat)

6. Verify token in controller must match the one in Meta  
   ![Step 6](https://img.shields.io/badge/Step%206-Verify%20Token-red?style=flat)

---

## 🌐 Deployment on Render

![Render Deploy](https://img.shields.io/badge/Deploy%20on-Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)

1. Push project to GitHub  
   ![GitHub](https://img.shields.io/badge/Push%20to-GitHub-181717?style=flat&logo=github)

2. Go to [https://render.com](https://render.com)  
   ![Render](https://img.shields.io/badge/Visit-Render.com-46E3B7?style=flat&logo=render)

3. Create a new **Web Service**  
   ![Web Service](https://img.shields.io/badge/Create-Web%20Service-blue?style=flat)

4. Set:
   - **Build Command**: `./mvnw clean package`  
     ![Build](https://img.shields.io/badge/Build-Maven-C71A36?style=flat&logo=apache-maven)
   - **Start Command**: `java -jar target/*.jar`  
     ![Start](https://img.shields.io/badge/Start-Java%20JAR-ED8B00?style=flat&logo=java)

5. Add environment variables:
   - `whatsapp.access.token`
   - `whatsapp.phone.number.id`
   - `firebase.config.path` (optional)

![Environment Variables](https://img.shields.io/badge/Setup-Environment%20Variables-yellow?style=flat&logo=dotenv)

---

## 🛡️ Security Notice

![Security](https://img.shields.io/badge/Security-Important-red?style=for-the-badge&logo=shield&logoColor=white)

- `serviceAccountKey.json` is **GIT IGNORED**.  
  ![Git Ignore](https://img.shields.io/badge/.gitignore-Protected-orange?style=flat&logo=git)
- Never commit your private key or API tokens.  
  ![Warning](https://img.shields.io/badge/Warning-No%20Secrets%20in%20Git-red?style=flat&logo=git)
- Always use environment variables for production deployments.  
  ![Best Practice](https://img.shields.io/badge/Best%20Practice-Environment%20Variables-green?style=flat)

---

## 📦 Dependencies

![Maven](https://img.shields.io/badge/Build%20Tool-Maven-C71A36?style=flat&logo=apache-maven&logoColor=white)

```xml
<!-- Firebase Admin SDK -->
<dependency>
  <groupId>com.google.firebase</groupId>
  <artifactId>firebase-admin</artifactId>
  <version>9.1.1</version>
</dependency>

<!-- Spring Web -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

---

## ✍️ Author

![Profile](https://img.shields.io/badge/Developer-Devansh%20Mohan%20Shrivastava-blue?style=for-the-badge&logo=github)

**Devansh Shrivastava**  
Java Developer | Web3 Enthusiast

![Java Developer](https://img.shields.io/badge/Role-Java%20Developer-ED8B00?style=flat&logo=java)
![Web3 Enthusiast](https://img.shields.io/badge/Enthusiast-Web3-purple?style=flat&logo=ethereum)

---

## 📄 License

![License](https://img.shields.io/badge/License-Educational%20Use-blue?style=for-the-badge)

This project is for educational and demo purposes. Commercial usage of WhatsApp APIs must comply with [Meta's terms of service](https://www.whatsapp.com/legal).

![Meta Terms](https://img.shields.io/badge/Compliance-Meta%20Terms-1877F2?style=flat&logo=meta)
