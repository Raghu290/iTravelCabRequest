

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csvreader.CsvWriter;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name = "AdminServlet1", urlPatterns = { "/login" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(" request name :"+ request.getParameter("name"));
		//System.out.println(" Latitude name :"+ request.getParameter("latitude"));
		System.out.println(" Longitude name :"+ request.getParameter("longitude"));
		writeCsvFile(request);
		
		 response.setContentType("text/html");  
         PrintWriter out=response.getWriter();  
         out.print("Your request for cab is placed successfully "+ request.getParameter("employeeName"));  
         out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// private static final Object [] FILE_HEADER = {"id","firstName","lastName","gender","age"};

	    public static void writeCsvFile(HttpServletRequest request) {

	         String outputFile = "/Users/raghu/EmployeeDetails.csv";
	         CsvWriter csvOutput =null;
	      try {
	        	 boolean alreadyExists = new File(outputFile).exists();
	             csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
	            if (!alreadyExists)
	            {
	                csvOutput.write("EmpID");
	                csvOutput.write("Name");
	                csvOutput.write("Address1");
	                csvOutput.write("Address2");
	                csvOutput.write("City");
	                csvOutput.write("State");
	                csvOutput.write("Country");
	                csvOutput.write("Pincode");
	                csvOutput.write("Gender");
	                csvOutput.write("Latitude");
	                csvOutput.write("Longitude");
	                csvOutput.endRecord();
	            }

	            csvOutput.write(request.getParameter("employeeId"));
	            csvOutput.write(request.getParameter("employeeName"));
	            csvOutput.write(request.getParameter("address1"));
	            csvOutput.write(request.getParameter("address2"));
	            csvOutput.write(request.getParameter("city"));
	            csvOutput.write(request.getParameter("state"));
	            csvOutput.write(request.getParameter("country"));
	            csvOutput.write(request.getParameter("pincode"));
	            csvOutput.write(request.getParameter("gender"));
	            csvOutput.write(request.getParameter("latitude"));
	            csvOutput.write(request.getParameter("longitude"));
	            csvOutput.endRecord();
	        	    
	           
	              
	            System.out.println("CSV file was created successfully !!!");

	             

	        } catch (Exception e) {

	            System.out.println("Error in CsvFileWriter !!!");

	            e.printStackTrace();

	        } finally {

	            try {

	            	 csvOutput.close();
	            } catch (Exception e) {

	                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");

	                e.printStackTrace();

	            }

	        }

	    }

}
