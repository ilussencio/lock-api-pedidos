import requests
import json
import concurrent.futures

json_data = {
	"quantidade":1,
	"produto": {
		"codigo": 1
	}
}

def send_post_request(url, data):
    try:
        response = requests.post(url, json=data)
        if response.status_code == 200:
            print(f"Requisição bem-sucedida para {url}")
        else:
            print(f"Falha na requisição para {url}, status code: {response.status_code}")
    except Exception as e:
        print(f"Erro ao enviar a requisição para {url}: {str(e)}")

#url = "http://localhost:8765/lock-optimistic/api/v1/pedidos"
url = "http://localhost:8765/lock-pessimistic/api/v1/pedidos"

num_requests = 1000000

with concurrent.futures.ThreadPoolExecutor() as executor:
    for _ in range(num_requests):
        executor.submit(send_post_request, url, json_data)