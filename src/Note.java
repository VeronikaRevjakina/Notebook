public class Note {

    private int id;
    private String title;
    private String context;

    public Note(){
        this(0, "", "");
    };

    public Note(int id,String title,String context){
        this.id=id;
        this.title=title;
        this.context=context;
    }

    public int getNoteId(){
        return this.id;
    }

    public String getNoteTitle(){
        return this.title;
    }

    public String getNoteContext(){
        return this.context;
    }

    public  Note changeFullNote(int id,String title,String context) {
        if (id >= 0) {
            this.id = id;
            this.title = title;
            this.context = context;
            System.out.println(this);
            return this;
        } else {
            throw new IndexOutOfBoundsException("Note index should be positive, change index value");
        }
    }

    public void setNoteId(int id){
        this.id=id;

    }

    public void setNoteTitle(String title){
        this.title=title;

    }

    public  void setNoteContext(String context){
        this.context=context;

    }

    @Override
    public String toString(){

        //return "id: "+id+" title: "+title+" context: "+context;
        return new StringBuilder().append("id ").append(id).append(" title: ").append(title).append(" context: ")
                .append(context).toString();
    }
}
