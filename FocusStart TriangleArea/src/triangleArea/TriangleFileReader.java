package triangleArea;

import java.io.*;

public class TriangleFileReader {

	public static void main(String[] args) {
		
		//проверка входных аргументов
		if ( args.length != 2 )
		{
			throw new IllegalArgumentException("Invalid input arguments");
		}
		
		File inputFile = new File("./", args[0]);
		File outputFile = new File("./", args[1]);

		//попытка создания выходного файла
		try{
			 if( outputFile.createNewFile() )
			 { System.out.println("Output file has been created");}
			 else
			 { System.out.println("Output file already created"); }
		}catch(IOException ex){       
			System.out.println(ex.getMessage());
		}  
		
		
		String str = null;	//строка для чтения из файла
		Triangle BiggestTriangle = new Triangle();
		Triangle CurrentTriangle = new Triangle();
		int numberWrongTriangle = 0;
		int numberIsoscelesTriangle = 0;
		int numberTriangle = 0;
		
		//пробуем читать файл
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			while( (str=br.readLine()) != null ){	//читаем, пока не кончится файл
				try  {
					CurrentTriangle = new Triangle(str);
					if( CurrentTriangle.IsoscelesCheck() )
					{
						if( CurrentTriangle.getArea() > BiggestTriangle.getArea())
						{
							BiggestTriangle = CurrentTriangle;
						}
						numberIsoscelesTriangle++;
						numberTriangle++;
					}
					else
					{
						numberTriangle++;
					}
				}
				catch(IllegalArgumentException e) {
					numberWrongTriangle++;
					//System.out.println( e );
				}
			}
			br.close();
		}
		catch(IOException ex){
			System.out.println(ex.getMessage() + "Input file can't be read");
		}
		
		//пробуем вывести в файл
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile)))
		{
			if( numberTriangle != 0 )
			{
				bw.write(BiggestTriangle.toString());
			}

			bw.close();
			System.out.println("Program finished\nNumber of triangle " + numberTriangle + "\n	Number of Isosceles triangle " + numberIsoscelesTriangle
					+ "\nNumber of wrong input string " + numberWrongTriangle + "\nBiggest Triangle = " + BiggestTriangle.toString() + "\nOutput file written");
		}
		catch(IOException ex){
			System.out.println(ex.getMessage() + "Output file can't be written");
		}
	
		
	}
}
