public class Main {

    public static void main(String[] args) {
        Note note1=new Note(1,"A","abc1");
        Note note2=new Note(2,"Ab","abc2");
        Note note3=new Note(3,"Abc","abc3");
        Note[] notes1={note1,note2};

        Notebook book1=new Notebook();
        book1.addNote(note1);
        book1.addNote(note2);
        book1.addNote(note3);
        book1.deleteLastNote();
        //book1.deleteLastNote();

       book1.deleteNoteById(1);
       book1.showAllNotes();

        /*book1.addNote(note3);
        book1.showAllNotes();
        book1.getNoteById(6);
        book1.addNote(note2);
        book1.deleteNote();
        book1.deleteNote();
        book1.showAllNotes();*/

        Note[] notes2={note1,note2,note3};
        Notebook book2=new Notebook(notes2);
        book2.showAllNotes();


    }
}
