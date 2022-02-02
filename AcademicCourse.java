public class AcademicCourse extends Course{
    
    //Defining attributes
    private String lecturerName;
    private String level;
    private String credit;
    private String startingDate;
    private String completionDate;
    private int numberOfAssessments;
    private boolean isRegistered;
    
    //Creating a constructor
    public AcademicCourse(String courseID,String courseName,int duration,String level,String credit,int numberOfAssessments){
        super(courseID,courseName,duration);
        this.level=level;
        this.credit=credit;
        this.numberOfAssessments=numberOfAssessments;
        this.lecturerName="";
        this.startingDate="";
        this.completionDate="";
        this.isRegistered=false;
    }
    
    //Creating accessor method for each attributes
    public String getLecturerName(){
        return this.lecturerName;
    }
    
    
    public String getLevel(){
        return this.level;
    }
    
    
    public String getCredit(){
        return this.credit;
    }
    
    
    public String getStartingDate(){
        return this.startingDate;
    }
    
    
    public String getCompletionDate(){
        return this.completionDate;
    }
    
    
    public int getNumberOfAssessments(){
        return this.numberOfAssessments;
    }
    
    
    public boolean getIsRegistered(){
        return this.isRegistered;
    }
    
    /*Creating mutator method for attributes 
      lecturerName and numberOfAssessments*/
    public void setLecturerName(String lecturerName){
        this.lecturerName=lecturerName;
    }
    
    
    public void setNumberOfAssessments(int numberOfAssessments){
        this.numberOfAssessments=numberOfAssessments;
    }
    
    //Method for registering AcademicCourse
    public void register(String courseLeader,String lecturerName,String startingDate,String completionDate){
        if(isRegistered==true){
            System.out.println("The lecturer name of academic course is " + lecturerName);
            System.out.println("The starting date of academic course is " + startingDate);
            System.out.println("The completion date of academic course is " + completionDate); 
        }else if(isRegistered==false){
            super.setCourseLeader(courseLeader);
            this.lecturerName=lecturerName;
            this.startingDate=startingDate;
            this.completionDate=completionDate;
            isRegistered=true;
        }
    }
    
    //Method to display detail of AcademicCourse
    public void display(){
       super.display();
       if(isRegistered==true){
            System.out.println("The lecturer name of academic course is " + lecturerName);
            System.out.println("The starting date of academic course is " + startingDate);
            System.out.println("The completion date of academic course is " + completionDate); 
            System.out.println("The level of academic course is " + level);
            System.out.println("The credit of academic course is " + credit); 
            System.out.println("The number of assessment of academic course is " + numberOfAssessments); 
        } 
    }
}
