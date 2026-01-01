# 🚀 AdWizzy – AI-Powered Advertisement Generator

AdWizzy is a full-stack AI-Powered platform that generates**(texts, videos)** using modern AI models,
It is designed to help businesses to create their digital marketing content quickly and efficiently.

----

## 🧠 features
1. ✍️ Ai-based Ad text generation.
2. 🎥 Ai video Ad generation.
3. ⚡ Rest APIs with Spring-Boot.
4. 📡 Async handling(Polling / Webhooks / Websockets -- Planned)
5. 🗃️ MongoDb For data storage.

----

## 🏗️ Tech Stack

  ### Backend
- Java 21
- Spring Boot
- REST APIs
- MongoDB
- External AI APIs (Gemini / Replicate / similar)

  ### Frontend (Planned)
- React / Next.js
- Axios
- WebSockets

----

## 📂 Project Structure
adWizzy/
|
|---backend.backend/
|              |
|              |--controller/
|              |
|              |--dto/
|              |
|              |--entity/
|              |
|              |--exception/
|              |
|              |--repsitory/
|              |              
|              |--service/
|              |
|              |--util/config/
|

-----

## 🔁 Workflow

  1. User provide their requirements (product, tone, platform)
  2. Backend APIs recieves the request
  3. AI engine generates the (text / image / video)
  4. Status will be tracked (processing ---> completed)
  5. Generated ad will return to the frontend

----

## 📌 Sample API Endpoint

```http
POST /api/ads/video/generate

Request Body
{
  "prompt": "Create a 30-second video ad for a sports shoe"
}

Response
{
  "status": "COMPLETED",
  "videoUrl": "https://example.com/generated-video.mp4"
}
```

----

🚧 Current status
   ✅ Backend architecture completed
   ✅ API structure ready
   ⚠️ AI engine integration (in progress)
   🔜 Webhooks & WebSockets integration(planned)
   🔜 Frontend development(planned)


🎯 Future Enhancements
  👥 User authentication
  🎫 Ad history dashboard
  📳 Multiple AI model support
  📲 Download & share ads
  🪪 Pricing & credits system



👨‍💻 Author

Ashish Balu
Java Developer | Spring Boot | REST APIs | MongoDB | Python 

⭐ Support
If you like this project, don’t forget to star ⭐ the repository!











