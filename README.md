# Spring AI Advisor Pipeline

A focused Spring Boot project for understanding how Spring AI Advisors transform requests, observe responses, and compose into an ordered `ChatClient` pipeline.

## What it demonstrates

- A Re-Reading (RE2) advisor that augments the user prompt before inference
- A logging advisor supporting both blocking and streaming calls
- Explicit advisor ordering through the Spring AI advisor contract
- Separate baseline and advised clients for behavior comparison
- API credentials supplied through environment variables

## Request flow

```text
HTTP request
   └── ChatClient
         ├── SimpleLoggerAdvisor
         ├── ReReadingAdvisor
         └── DeepSeekChatModel
```

## Run locally

Requirements: JDK 17+ and Maven 3.9+.

```bash
export DEEPSEEK_API_KEY='your-deepseek-key'
mvn clean spring-boot:run
```

Compare the baseline and advised paths:

```bash
curl --get 'http://localhost:8080/api/chat' \
  --data-urlencode 'message=Explain hybrid retrieval in three points'

curl --get 'http://localhost:8080/api/chat/re-read' \
  --data-urlencode 'message=Explain hybrid retrieval in three points'
```

## Extension points

- Adjust `getOrder()` to study advisor execution order.
- Replace RE2 with guardrail, memory, or retrieval advisors.
- Send logs to an observability backend after adding prompt redaction.
- Add golden-case evaluations to compare output quality across advisor changes.

## Tech stack

- Java 17
- Spring Boot 3.5
- Spring AI 1.1
- DeepSeek Chat Model
- Reactor
