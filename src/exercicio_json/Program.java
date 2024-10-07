package exercicio_json;

import org.json.JSONArray;
import org.json.JSONObject;

public class Program {

	public static void main(String[] args) {
			
			String jsonData = """
					{ 
						"faturamento": [
							{"day": 1, "value": 9230.875},
							{"day": 2, "value": 15432.453},
							{"day": 3, "value": 11123.333},
							{"day": 4, "value": 20012.344},
							{"day": 5, "value": 22434.225},
							{"day": 6, "value": 0.0},
							{"day": 7, "value": 0.0},
							{"day": 8, "value": 78654.111},
							{"day": 9, "value": 34235.345},
							{"day": 10, "value": 11236.954},
							{"day": 11, "value": 15432.934},
							{"day": 12, "value": 15432.657},
							{"day": 13, "value": 0.0},
							{"day": 14, "value": 0.0},
							{"day": 15, "value": 23405.321},
							{"day": 16, "value": 15322.345},
							{"day": 17, "value": 13578.786},
							{"day": 18, "value": 11357.341},
							{"day": 19, "value": 20034.457},
							{"day": 20, "value": 0.0},
							{"day": 21, "value": 0.0},
							{"day": 22, "value": 22479.046},
							{"day": 23, "value": 8635.112},
							{"day": 24, "value": 35811.099},
							{"day": 25, "value": 23954.563},
							{"day": 26, "value": 0.0},
							{"day": 27, "value": 0.0},
							{"day": 28, "value": 23145.131},
							{"day": 29, "value": 39567.793},
							{"day": 30, "value": 29513.999},
						]
					
					}
					""";
			
			JSONObject obj1 = new JSONObject(jsonData);
			JSONArray faturamentoArray = obj1.getJSONArray("faturamento");
			
			double maior = Double.MIN_VALUE, menor = Double.MAX_VALUE, soma = 0;
			int dias = 0, menorDia = 0, maiorDia = 0;
			
			for(int i = 0; i < faturamentoArray.length(); i++) {
				JSONObject dia = faturamentoArray.getJSONObject(i);
				double valor = dia.getDouble("value");
				if(valor > 0) {
					if(valor < menor) {
						menor = valor;
					}
					if(valor > maior) {
						maior = valor;
					}
					soma += valor;
					dias++;
					if(valor == menor) {
						menorDia = dia.getInt("day");
					}
					if(valor == maior) {
						maiorDia = dia.getInt("day");
					}
				}
			}
			
			double avg = soma / dias;
			
			int diasAcimaDaMedia = 0;
			
			for(int i = 0; i < faturamentoArray.length(); i++) {
				JSONObject dia = faturamentoArray.getJSONObject(i);
				double valor = dia.getDouble("value");
				if(valor > avg) {
					diasAcimaDaMedia++;
				}
			}
			
			System.out.println("O dia: " + menorDia +" teve o menor valor de faturamento: " + menor);
			System.out.println("O dia: " + maiorDia + " teve o maior valor de faturamento: " + maior);
			System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
	}
}
