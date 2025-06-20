# 🤖 WhatsApp Chatbot Backend using Java & Spring Boot

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

| Technology     | Purpose                           |
|----------------|-----------------------------------|
| Java 17+       | Core language                     |
| Spring Boot    | Backend framework                 |
| Firebase Admin SDK | Chat storage / user logs       |
| WhatsApp Cloud API | Send/receive WhatsApp messages |
| Render / ngrok | Deployment / local webhook testing |

---

## 🏗️ Project Structure

\`\`\`
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
\`\`\`

---

## 🛠️ Setup Instructions

### 1. Clone the repo

\`\`\`bash
git clone https://github.com/yourusername/whatsapp-chatbot-backend.git
cd whatsapp-chatbot-backend
\`\`\`

### 2. Add Firebase service account key

- Go to [Firebase Console](https://console.firebase.google.com/)
- Navigate to **Project Settings > Service Accounts**
- Click **Generate new private key**
- Save the downloaded \`serviceAccountKey.json\` in \`src/main/resources/\`

### 3. Configure application properties

\`\`\`properties
server.port=8080

whatsapp.phone.number.id=YOUR_PHONE_NUMBER_ID
whatsapp.access.token=YOUR_TEMP_ACCESS_TOKEN
firebase.config.path=classpath:serviceAccountKey.json
\`\`\`

### 4. Start the server

\`\`\`bash
./mvnw spring-boot:run
\`\`\`

### 5. Expose webhook for WhatsApp (if local)

\`\`\`bash
ngrok http 8080
\`\`\`

Use the generated URL to set up webhook in Meta Developer Console.

---

## ✅ WhatsApp Webhook Setup (Cloud API Sandbox)

1. Go to [Meta for Developers](https://developers.facebook.com)
2. Create a **Business App**
3. Add the **WhatsApp product**
4. Link a test phone number
5. Register your webhook (e.g., \`https://xyz.ngrok.io/webhook\`)
6. Verify token in controller must match the one in Meta

---

## 🌐 Deployment on Render

1. Push project to GitHub
2. Go to [https://render.com](https://render.com)
3. Create a new **Web Service**
4. Set:
   - **Build Command**: \`./mvnw clean package\`
   - **Start Command**: \`java -jar target/*.jar\`
5. Add environment variables:
   - \`whatsapp.access.token\`
   - \`whatsapp.phone.number.id\`
   - \`firebase.config.path\` (optional)

---

## 🛡️ Security Notice

- \`serviceAccountKey.json\` is **GIT IGNORED**.
- Never commit your private key or API tokens.
- Always use environment variables for production deployments.

---

## 📦 Dependencies

\`\`\`xml
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
\`\`\`

---

## ✍️ Author

**Devansh Mohan Shrivastava**  
Java Developer | Firebase & Web3 Enthusiast

---

## 📄 License

This project is for educational and demo purposes. Commercial usage of WhatsApp APIs must comply with [Meta's terms of service](https://www.whatsapp.com/legal).
