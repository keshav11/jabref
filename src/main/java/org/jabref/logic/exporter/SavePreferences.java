package org.jabref.logic.exporter;

import java.nio.charset.Charset;
import java.util.Collections;

import org.jabref.logic.bibtex.LatexFieldFormatterPreferences;
import org.jabref.model.bibtexkeypattern.GlobalBibtexKeyPattern;
import org.jabref.model.metadata.SaveOrderConfig;

public class SavePreferences {

    // Encoding written at the top of the .bib file.
    public static final String ENCODING_PREFIX = "Encoding: ";

    private final boolean reformatFile;
    private final boolean saveInOriginalOrder;
    private final SaveOrderConfig saveOrder;
    private final Charset encoding;
    private final boolean makeBackup;
    private final DatabaseSaveType saveType;
    private final boolean takeMetadataSaveOrderInAccount;
    private final LatexFieldFormatterPreferences latexFieldFormatterPreferences;
    private final GlobalBibtexKeyPattern globalCiteKeyPattern;
    private final Boolean generateBibtexKeysBeforeSaving;

    public SavePreferences() {
        this(true, null, null, false, DatabaseSaveType.ALL, true, false, new LatexFieldFormatterPreferences(),
                new GlobalBibtexKeyPattern(Collections.emptyList()), false);
    }

    public SavePreferences(Boolean saveInOriginalOrder, SaveOrderConfig saveOrder, Charset encoding, Boolean makeBackup,
                           DatabaseSaveType saveType, Boolean takeMetadataSaveOrderInAccount, Boolean reformatFile,
                           LatexFieldFormatterPreferences latexFieldFormatterPreferences, GlobalBibtexKeyPattern globalCiteKeyPattern, Boolean generateBibtexKeysBeforeSaving) {
        this.saveInOriginalOrder = saveInOriginalOrder;
        this.saveOrder = saveOrder;
        this.encoding = encoding;
        this.makeBackup = makeBackup;
        this.saveType = saveType;
        this.takeMetadataSaveOrderInAccount = takeMetadataSaveOrderInAccount;
        this.reformatFile = reformatFile;
        this.latexFieldFormatterPreferences = latexFieldFormatterPreferences;
        this.globalCiteKeyPattern = globalCiteKeyPattern;
        this.generateBibtexKeysBeforeSaving = generateBibtexKeysBeforeSaving;
    }

    public Boolean getTakeMetadataSaveOrderInAccount() {
        return takeMetadataSaveOrderInAccount;
    }

    public SaveOrderConfig getSaveOrder() {
        return saveOrder;
    }

    public boolean isSaveInOriginalOrder() {
        return saveInOriginalOrder;
    }

    public SavePreferences withSaveInOriginalOrder(Boolean newSaveInOriginalOrder) {
        return new SavePreferences(newSaveInOriginalOrder, this.saveOrder, this.encoding, this.makeBackup, this.saveType,
                this.takeMetadataSaveOrderInAccount, this.reformatFile, this.latexFieldFormatterPreferences,
                this.globalCiteKeyPattern, this.generateBibtexKeysBeforeSaving);
    }

    public boolean makeBackup() {
        return makeBackup;
    }

    public SavePreferences withMakeBackup(Boolean newMakeBackup) {
        return new SavePreferences(this.saveInOriginalOrder, this.saveOrder, this.encoding, newMakeBackup, this.saveType,
                this.takeMetadataSaveOrderInAccount, this.reformatFile, this.latexFieldFormatterPreferences,
                this.globalCiteKeyPattern, this.generateBibtexKeysBeforeSaving);
    }

    public Charset getEncoding() {
        return encoding;
    }

    public SavePreferences withEncoding(Charset newEncoding) {
        return new SavePreferences(this.saveInOriginalOrder, this.saveOrder, newEncoding, this.makeBackup, this.saveType,
                this.takeMetadataSaveOrderInAccount, this.reformatFile, this.latexFieldFormatterPreferences,
                this.globalCiteKeyPattern, this.generateBibtexKeysBeforeSaving);
    }

    public DatabaseSaveType getSaveType() {
        return saveType;
    }

    public SavePreferences withSaveType(DatabaseSaveType newSaveType) {
        return new SavePreferences(this.saveInOriginalOrder, this.saveOrder, this.encoding, this.makeBackup, newSaveType,
                this.takeMetadataSaveOrderInAccount, this.reformatFile, this.latexFieldFormatterPreferences,
                this.globalCiteKeyPattern, this.generateBibtexKeysBeforeSaving);
    }

    public Boolean isReformatFile() {
        return reformatFile;
    }

    public SavePreferences withReformatFile(boolean newReformatFile) {
        return new SavePreferences(this.saveInOriginalOrder, this.saveOrder, this.encoding, this.makeBackup,
                this.saveType, this.takeMetadataSaveOrderInAccount, newReformatFile, this.latexFieldFormatterPreferences,
                this.globalCiteKeyPattern, this.generateBibtexKeysBeforeSaving);
    }

    public Charset getEncodingOrDefault() {
        return encoding == null ? Charset.defaultCharset() : encoding;
    }

    public LatexFieldFormatterPreferences getLatexFieldFormatterPreferences() {
        return latexFieldFormatterPreferences;
    }

    public GlobalBibtexKeyPattern getGlobalCiteKeyPattern() {
        return globalCiteKeyPattern;
    }

    public Boolean generateBibtexKeysBeforeSaving() {
        return generateBibtexKeysBeforeSaving;
    }

    public enum DatabaseSaveType {
        ALL,
        PLAIN_BIBTEX
    }
}
