package it.unimib.disco.asia.backend.response;

import java.util.Map;

public class MatchResult<T> {

    private MatchMetaData meta;

    private Map<T, MatchList<T>> rows;

    public MatchMetaData getMeta() {
        return meta;
    }

    public void setMeta(MatchMetaData meta) {
        this.meta = meta;
    }

    public Map<T, MatchList<T>> getRows() {
        return rows;
    }

    public void setRows(Map<T, MatchList<T>> rows) {
        this.rows = rows;
    }
}
