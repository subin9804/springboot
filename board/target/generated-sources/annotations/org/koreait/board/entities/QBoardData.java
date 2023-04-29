package org.koreait.board.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardData is a Querydsl query type for BoardData
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardData extends EntityPathBase<BoardData> {

    private static final long serialVersionUID = 1558410222L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardData boardData = new QBoardData("boardData");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath boardId = createString("boardId");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDt = _super.modDt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    public final StringPath subject = createString("subject");

    public final QUsers user;

    public QBoardData(String variable) {
        this(BoardData.class, forVariable(variable), INITS);
    }

    public QBoardData(Path<? extends BoardData> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardData(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardData(PathMetadata metadata, PathInits inits) {
        this(BoardData.class, metadata, inits);
    }

    public QBoardData(Class<? extends BoardData> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

