public class Course{
    
    //Defining attributes
    private String courseID;
    private String courseName;
    private String courseLeader;
    private int duration;
    
    //Creating a constructor
    public Course(String courseID,String courseName,int duration){
        this.courseID=courseID;
        this.courseName=courseName;
        this.duration=duration;
        this.courseLeader="";
        }
        
    //Creating accessor method for each attributes    
    public String getCourseID(){
        return this.courseID;
    } 
    
    
    public String getCourseName(){
        return this.courseName;
    }
    
    public String getCourseLeader(){
        return this.courseLeader;
    }
    
    
    public int getDuration(){
        return this.duration;
    }
    
    //Creating mutator method for attribute courseLeader
    public void setCourseLeader(String courseLeader){
        this.courseLeader=courseLeader;
    }
    
    //Method to display detail of Course
    public void display(){
        System.out.println("The course id is " + courseID);
        System.out.println("The course name is " + courseName);
        System.out.println("The course duration is " + duration + " weeks");
        
        if(!courseLeader.equals("")){
            System.out.println("The course leader name is "  + courseLeader);
        }
    }
}
