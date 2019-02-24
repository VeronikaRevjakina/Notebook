public class Note {

    private int id;
    private String title;
    private String context;

    Note(){
        id=0;
        title="";
        context="";
    };

    Note(int id,String title,String context){
        this.id=id;
        this.title=title;
        this.context=context;
    }

    public int getNoteId(Note note){
        return note.id;
    }

    public String getNoteTitle(Note note){
        return note.title;
    }

    public String getNoteContext(Note note){
        return note.context;
    }

    public  Note changeFullNote(int id,String title,String context){
        this.id=id;
        this.title=title;
        this.context=context;
        System.out.println( this.toString());
        return this;
    }

    public Note setNoteId(int id){
        this.id=id;
        return this;
    }

    public Note setNoteTitle(String title){
        this.title=title;
        return this;
    }

    public  Note setNoteContext(String context){
        this.context=context;
        return this;
    }

    @Override
    public String toString(){
        return "id: "+id+" title: "+title+" context: "+context;
    }
}
