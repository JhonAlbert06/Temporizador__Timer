public class Tiempo{

	byte hora;
	byte minuto;
	byte segundo;
	
	public Tiempo(int  hora, int minuto,int segundo){
     
    	this.hora=(byte)hora;
    	this.minuto=(byte)minuto;
    	this.segundo=(byte)segundo;

	}

	public void setHora(int hor){

		if (hor > 0 && hor < 24)
			hora = (byte)hor;
	}

	public void setMinuto(int min){

		if (min > 0 && min < 60)
			minuto = (byte)min;
	}

	public void setSegundo(int seg){

		if (seg > 0 && seg < 60)
			segundo = (byte)seg;
	}

	public void desSegundo(int seg){
		
		for(int i = 0; i < seg; i++){

			if(segundo == 0 && minuto == 0 && hora > 0){	
			
				segundo = 59;
				minuto = 59;
				hora--;
				
			}

			if (segundo == 0 && minuto != 0){

				segundo = 59;
				minuto--;

				if (minuto == 0 && hora > 0){

					hora--;
					minuto = 59;
					segundo = 59;

				}
			}

			segundo--;
			
			
		}
	}

	public void incSegundo(int seg){

		for(int i = 0; i < seg; i++){

			segundo++;

			if (segundo == 60){
				segundo = 0;
				minuto++;

				if (minuto == 60){
					minuto = 0;
					hora++;

					if (hora == 24)
						hora = 0;
				}

			}
		}
	}

	@Override
	public String toString(){

		String[] aux = new String[3];

		if (hora < 10)
			aux[0] = "0" + hora;
		else
			aux[0] = "" + hora;

		if (minuto < 10)
			aux[1] = "0" + minuto;
		else
			aux[1] = "" + minuto;

		if (segundo < 10)
			aux[2] = "0" + segundo;
		else
			aux[2] = "" + segundo;

	    return aux[0] + " : " + aux[1] + " : " + aux[2];
	}
}