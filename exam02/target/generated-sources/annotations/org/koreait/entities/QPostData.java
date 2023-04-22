package org.koreait.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostData is a Querydsl query type for PostData
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostData extends EntityPathBase<PostData> {

    private static final long serialVersionUID = 513986356L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPostData postData = new QPostData("postData");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDt = _super.modDt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    public final StringPath subject = createString("subject");

    public final QUsers user;

    public QPostData(String variable) {
        this(PostData.class, forVariable(variable), INITS);
    }

    public QPostData(Path<? extends PostData> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPostData(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPostData(PathMetadata metadata, PathInits inits) {
        this(PostData.class, metadata, inits);
    }

    public QPostData(Class<? extends PostData> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

