# chatGPT
PoC integración ChatGPT

API details

curl --location --request POST 'http://localhost:8090/api/v1/chatGPT/send' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "What is gpt"
}'
