public class Notebook {

    public static final int INITIAL_SIZE=2;
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
        if (last ==notes.length) {
            Note[] tempNotes = new Note[INITIAL_SIZE * 2];
            this.notes = this.helpArrayCopyMethod(tempNotes);;
        }
        this.notes[last] = note;
        last++;
    }


    public void deleteLastNote() {
        last--;
        if (notes.length/INITIAL_SIZE !=(last-1)) {
            this.notes[last] = null;

        }
        else {
            Note[] tempNotes = new Note[this.notes.length/2];
            this.notes = this.helpArrayCopyMethod(tempNotes);
        }
    }

    public void deleteNoteById(int id) {
        if (this.checkNoteExistsById(id) == true) {
            Note[] tempNotes = new Note[this.notes.length - 1];
            System.arraycopy(this.notes, 0, tempNotes, 0, id);
            System.arraycopy(this.notes, id + 1, tempNotes, id, notes.length - id - 1);
            last--;
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

    private Note[] helpArrayCopyMethod(Note[] tempNotes){
       /*for (int i = 0; i < last; i++) {
                tempNotes[i] = this.notes[i];
            }*/

        System.arraycopy (this.notes, 0, tempNotes, 0, last);
        return tempNotes;
    }

    private boolean checkNoteExistsById(int id){
        if (id >= 0 && id <= last) {
           return true;
        }
        else{
            throw new IndexOutOfBoundsException("Note with this index does not exist,change index");
        }
    }

}
