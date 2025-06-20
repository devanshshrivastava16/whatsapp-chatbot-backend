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

whatsapp-chatbot-backend/
├── controller/
│ └── WhatsAppWebhookController.java
├── service/
│ ├── WhatsAppService.java
│ └── FirebaseInitializer.java
├── model/
│ └── Message.java
├── resources/
│ ├── application.properties
│ └── serviceAccountKey.json # 🚫 IGNORED
├── WhatsappChatbotApplication.java
├── pom.xml
└── README.md


---

## 🛠️ Setup Instructions

### 1. Clone the repo

```bash
git clone https://github.com/yourusername/whatsapp-chatbot-backend.git
cd whatsapp-chatbot-backend
```
2. Add Firebase service account key
Go to [Firebase Console](https://console.firebase.google.com/)

Navigate to Project Settings > Service Accounts

Click Generate new private key

Save the downloaded serviceAccountKey.json in src/main/resources/

3. Configure application properties

server.port=8080

whatsapp.phone.number.id=YOUR_PHONE_NUMBER_ID
whatsapp.access.token=YOUR_TEMP_ACCESS_TOKEN
firebase.config.path=classpath:serviceAccountKey.json


