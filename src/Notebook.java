public class Notebook {

    public static final int INITIAL_SIZE=100;
    private Note[] notes;
    private int last;

    public Notebook(){
        this.notes=new Note[INITIAL_SIZE];
        last=0;
    }

    public Notebook(Note[] notesIn){
        this();
        for(Note note:notesIn){
            this.addNote(note);
        }
    }

    public void addNote(Note note) {
        if (last !=notes.length) {
            this.notes[last]=note;
            last++;
        } else {
            Note[] tempNotes = new Note[INITIAL_SIZE*2];
            for (int i = 0; i < last; i++) {
                tempNotes[i] = this.notes[i];
            }
            tempNotes[last] = note;
            last++;
            this.notes = tempNotes;
        }
    }


    public void deleteNote() {
        if (notes.length/INITIAL_SIZE !=(last-1)) {
            last--;
            this.notes[last] = null;

        }
        else {
            last--;
            Note[] tempNotes = new Note[this.notes.length/2];
            for (int i = 0; i < last; i++) {
                tempNotes[i] = this.notes[i];

            }
            this.notes = tempNotes;
        }
    }

    public Note getNoteById(int id){
            if (id >= 0 && id <= last) {
                System.out.println(this.notes[id]);
                return this.notes[id];
            }
            else{
                throw new IndexOutOfBoundsException("Note with this index does not exist,change index");
        }
    }

    public void showAllNotes(){
        for(int i=0;i<last;i++){
            System.out.println( this.notes[i]);
        }
    }
}
