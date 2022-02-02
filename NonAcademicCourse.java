public class NonAcademicCourse extends Course{
    
    //Defining attributes
    private String instructorName;
    private String startDate;
    private String completionDate;
    private String examDate;
    private String prerequisite;
    private boolean isRegistered;
    private boolean isRemoved;
    
    //Creating a constructor
    public NonAcademicCourse(String courseID,String courseName,int duration,String prerequisite){
        super(courseID,courseName,duration);
        this.prerequisite=prerequisite;
        this.startDate="";
        this.completionDate="";
        this.examDate="";
        this.isRegistered=false;
        this.isRemoved=false;
    }
    
    //Creating accessor method for each attributes
    public String getInstructorName(){
         return this.instructorName;
    }
    
    
    public String getStartDate(){
        return this.startDate;
    }
    
    
    public String getCompletionDate(){
        return this.completionDate;
    }
    
    
    public String getExamDate(){
        return this.examDate;
    }
    
    public String getPrerequisite(){
        return this.prerequisite;
    }
    
    public boolean getIsRegistered(){
        return this.isRegistered;
    }
    
    
    public boolean getIsRemoved(){
        return this.isRemoved;
    }
    
    //Creating mutator method for attribute instructorName
    public void setInstructorName(String instructorName){
        if(isRegistered==false){
            this.instructorName=instructorName;
        }else if(isRegistered==true){
            System.out.println("The non-academic course has already been registered. Therefore, it is not possible to change the instructor's name. ");
        }
    }
    
    //Method to register NonAcademicCourse
    public void register(String courseLeader,String instructorName,String startDate,String completionDate,String examDate){
        if(isRegistered==false){
            super.setCourseLeader(courseLeader);
            this.setInstructorName(instructorName);
            this.startDate=startDate;
            this.completionDate=completionDate;
            this.examDate=examDate;
            this.isRegistered=true;
            this.isRemoved=false;
        }else if(isRegistered==true){
            System.out.println("The non academic course has already been registered.");
        }
    }
            
    //Mehtod to remove NonAcademicCourse       
    public void remove(){
        if(isRemoved==true){
            System.out.println("The non academic course has already been removed.");
                     
        }else if(isRemoved==false){
            super.setCourseLeader("");
            this.instructorName="";
            this.startDate="";
            this.completionDate="";
            this.examDate="";
            this.isRegistered=false;
            this.isRemoved=true;
        }
    }
    
    //Method to display detail of NonAcademicCourse
    public void display(){
        super.display();
        if(isRegistered==true){
            System.out.println("The instructor name is " + instructorName);
            System.out.println("The starting date is " + startDate);
            System.out.println("The completion date is " + completionDate);
            System.out.println("The examDate is " + examDate);
        }
    }
}
