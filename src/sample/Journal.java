package sample;

import java.time.LocalDate;

public class Journal {

    private String journalText = null;

    private LocalDate journalDate = null;

    public Journal(){

    }

    public Journal(String jT, LocalDate jD){
        this.setJournalText(jT);
        this.setJournalDate(jD);
    }
// this is a test
    public String getJournalText() {
        return journalText;
    }

    public void setJournalText(String journalText) {
        this.journalText = journalText;
    }

    public LocalDate getJournalDate() {
        return journalDate;
    }

    public void setJournalDate(LocalDate journalDate) {
        validateNotNull(journalDate, "journalDate");
        this.journalDate = journalDate;
    }

    private void validateNotNull(Object parm, String name) {
        if(parm == null) {
            throw new IllegalArgumentException(
                    String.format("%s cannot be null", name)
            );
        }
    }

    public String serialize(){
        return String.format("%s|%s",
                this.getJournalDate().toString(),
                this.getJournalText());
    }

    public void deserialize(String line) {
        String[] pieces = line.split("\\|");
        String[] datePieces = pieces[0].trim().split("-");
        LocalDate ld = LocalDate.of(
                Integer.parseInt(datePieces[0].trim()),
                Integer.parseInt(datePieces[1].trim()),
                Integer.parseInt(datePieces[2].trim())
        );
        this.setJournalDate(ld);
        this.setJournalText(pieces[1].trim());

    }


    @Override
    public String toString() {
        return String.format(
                "%s",
                this.getJournalDate().toString());
    }
}
