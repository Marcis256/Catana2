package com.boardGame.Catana.model;

import lombok.Getter;

import java.util.List;

@Getter
public enum SettlementPlaces {

    settlement_1(List.of(Board.TILE_1)),
    settlement_2(List.of(Board.TILE_2)),
    settlement_3(List.of(Board.TILE_3)),
    settlement_4(List.of(Board.TILE_1)),
    settlement_5(List.of(Board.TILE_1, Board.TILE_2)),
    settlement_6(List.of(Board.TILE_2, Board.TILE_3)),
    settlement_7(List.of(Board.TILE_3)),
    settlement_8(List.of(Board.TILE_1, Board.TILE_4)),
    settlement_9(List.of(Board.TILE_1, Board.TILE_2, Board.TILE_5)),
    settlement_10(List.of(Board.TILE_2, Board.TILE_3, Board.TILE_6)),
    settlement_11(List.of(Board.TILE_3, Board.TILE_7)),
    settlement_12(List.of(Board.TILE_4)),
    settlement_13(List.of(Board.TILE_1, Board.TILE_4, Board.TILE_5)),
    settlement_14(List.of(Board.TILE_2, Board.TILE_5, Board.TILE_6)),
    settlement_15(List.of(Board.TILE_3, Board.TILE_6, Board.TILE_7)),
    settlement_16(List.of(Board.TILE_7)),
    settlement_17(List.of(Board.TILE_4, Board.TILE_8)),
    settlement_18(List.of(Board.TILE_4, Board.TILE_5, Board.TILE_9)),
    settlement_19(List.of(Board.TILE_5, Board.TILE_6, Board.TILE_10)),
    settlement_20(List.of(Board.TILE_6, Board.TILE_7, Board.TILE_11)),
    settlement_21(List.of(Board.TILE_7, Board.TILE_12)),
    settlement_22(List.of(Board.TILE_8)),
    settlement_23(List.of(Board.TILE_4, Board.TILE_8, Board.TILE_9)),
    settlement_24(List.of(Board.TILE_5, Board.TILE_9, Board.TILE_10)),
    settlement_25(List.of(Board.TILE_6, Board.TILE_10, Board.TILE_11)),
    settlement_26(List.of(Board.TILE_7, Board.TILE_11, Board.TILE_12)),
    settlement_27(List.of(Board.TILE_12)),
    settlement_28(List.of(Board.TILE_8)),
    settlement_29(List.of(Board.TILE_8, Board.TILE_9, Board.TILE_13)),
    settlement_30(List.of(Board.TILE_9, Board.TILE_10, Board.TILE_14)),
    settlement_31(List.of(Board.TILE_10, Board.TILE_11, Board.TILE_15)),
    settlement_32(List.of(Board.TILE_11, Board.TILE_12, Board.TILE_16)),
    settlement_33(List.of(Board.TILE_12)),
    settlement_34(List.of(Board.TILE_8, Board.TILE_13)),
    settlement_35(List.of(Board.TILE_9, Board.TILE_13, Board.TILE_14)),
    settlement_36(List.of(Board.TILE_10, Board.TILE_14, Board.TILE_15)),
    settlement_37(List.of(Board.TILE_11, Board.TILE_15, Board.TILE_16)),
    settlement_38(List.of(Board.TILE_12, Board.TILE_16)),
    settlement_39(List.of(Board.TILE_13)),
    settlement_40(List.of(Board.TILE_13, Board.TILE_14, Board.TILE_17)),
    settlement_41(List.of(Board.TILE_14, Board.TILE_15, Board.TILE_18)),
    settlement_42(List.of(Board.TILE_15, Board.TILE_16, Board.TILE_19)),
    settlement_43(List.of(Board.TILE_16)),
    settlement_44(List.of(Board.TILE_13, Board.TILE_17)),
    settlement_45(List.of(Board.TILE_14, Board.TILE_17, Board.TILE_18)),
    settlement_46(List.of(Board.TILE_15, Board.TILE_18, Board.TILE_19)),
    settlement_47(List.of(Board.TILE_16, Board.TILE_19)),
    settlement_48(List.of(Board.TILE_17)),
    settlement_49(List.of(Board.TILE_17, Board.TILE_18)),
    settlement_50(List.of(Board.TILE_18, Board.TILE_19)),
    settlement_51(List.of(Board.TILE_19)),
    settlement_52(List.of(Board.TILE_17)),
    settlement_53(List.of(Board.TILE_18)),
    settlement_54(List.of(Board.TILE_19));

    private List<Board> boards;

    private SettlementPlaces(List<Board> boards){
        this.boards = boards;
    }

}
