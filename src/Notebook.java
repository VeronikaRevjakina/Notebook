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

    public int getLast(){
        return this.last;
    }

    public Note[] getNotes(){
        return this.notes;
    }

    public void addNote(Note note) {
        if (last ==notes.length) {
            Note[] tempNotes = new Note[notes.length * 2];
            this.notes = this.helpArrayCopyMethod(tempNotes);;
        }
        this.notes[last] = note;
        last++;
    }


    public void deleteLastNote() {
        if (last >= 0) {
            last--;
            if (notes.length / INITIAL_SIZE != last ) {
                this.notes[last] = null;

            } else {
                Note[] tempNotes = new Note[this.notes.length / 2];
                this.notes = helpArrayCopyMethod(tempNotes);
            }
        }
        else{
            throw new IndexOutOfBoundsException("Notebook is empty");
        }
    }

    public void deleteNoteById(int id) {
        if (this.checkNoteExistsById(id)) {
            Note[] tempNotes = new Note[this.notes.length - 1];
            System.arraycopy(this.notes, 0, tempNotes, 0, id);
            System.arraycopy(this.notes, id + 1, tempNotes, id, notes.length - id - 1);
            last--;
            this.notes = tempNotes;
            if (this.notes.length/INITIAL_SIZE ==(last) ){
                Note[] temporaryNotes = new Note[this.notes.length/2];
                this.notes = this.helpArrayCopyMethod(temporaryNotes);
            }

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

    private Note[] helpArrayCopyMethod(Note[] temporNotes){
       for (int i = 0; i < last; i++) {
                temporNotes[i] = this.notes[i];
            }

        /*System.arraycopy (this.notes, 0, tempNotes, 0, last);*/
        return temporNotes;
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
