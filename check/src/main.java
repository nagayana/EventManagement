import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pojo.Attraction;
import com.project.pojo.Designation;
import com.project.service.AttractionServiceImp;
import com.project.service.DesignationServiceImp;
import com.project.service.EventServiceImp;

public class main {

	public static void main(String[] args) {
		AttractionServiceImp obj=new AttractionServiceImp();
		DesignationServiceImp obj2=new DesignationServiceImp();
		Attraction attraction=new Attraction(11,"singing","faridabad",1,5,100);
		try {
			obj.deleteAttraction(11);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<Designation> list=obj2.getAllDesignations();
			for(Designation d:list)
			{
				System.out.println(d);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventServiceImp e=new EventServiceImp();
		try {
			System.out.println(e.getEvent(100));
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
