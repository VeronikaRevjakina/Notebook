public class Notebook {

    public static final int initialSize=2;
    private Note[] notes;
    private int last;

    Notebook(){
        this.notes=new Note[initialSize];
        last=0;
    }

    Notebook(Note[] notesIn){
        this();
        for(Note i:notesIn){
            this.addNote(i);
        }
    }

    void addNote(Note note) {
        if (last !=notes.length) {
            this.notes[last]=note;
            last++;
        }
        else {
            Note[] tempNotes = new Note[initialSize*2];
            for (int i = 0; i < last; i++) {
                tempNotes[i] = this.notes[i];
            }
            tempNotes[last] = note;
            last++;
            this.notes = tempNotes;
        }
    }


    void deleteNote() {
        if (notes.length/initialSize !=(last-1)) {
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

    Note getNoteByCount(int count){
        if(count <= last) {
            System.out.println( this.notes[count].toString());
            return this.notes[count];
        }
        System.out.println( new Note().toString());
        return new Note();
    }

    void showAllNotes(){
        for(int i=0;i<this.notes.length;i++){
            if(this.notes[i] ==null){
                break;
            }
            System.out.println( this.notes[i].toString());
        }
    }
}
