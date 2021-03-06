package com.github.lwhite1.tablesaw.filtering.times;

import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.ColumnReference;
import com.github.lwhite1.tablesaw.api.TimeColumn;
import com.github.lwhite1.tablesaw.filtering.ColumnFilter;
import org.roaringbitmap.RoaringBitmap;

import java.time.LocalTime;

/**
 *
 */
public class IsAfter extends ColumnFilter {

  private LocalTime value;

  public IsAfter(ColumnReference reference, LocalTime value) {
    super(reference);
    this.value = value;
  }

  public RoaringBitmap apply(Table relation) {
    TimeColumn timeColumn = (TimeColumn) relation.column(columnReference().getColumnName());
    return timeColumn.isAfter(value);
  }
}
