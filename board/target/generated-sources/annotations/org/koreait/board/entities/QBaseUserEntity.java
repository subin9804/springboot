package org.koreait.board.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseUserEntity is a Querydsl query type for BaseUserEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseUserEntity extends EntityPathBase<BaseUserEntity> {

    private static final long serialVersionUID = -258229311L;

    public static final QBaseUserEntity baseUserEntity = new QBaseUserEntity("baseUserEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDt = _super.modDt;

    public final NumberPath<Long> modifiedBy = createNumber("modifiedBy", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    public QBaseUserEntity(String variable) {
        super(BaseUserEntity.class, forVariable(variable));
    }

    public QBaseUserEntity(Path<? extends BaseUserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseUserEntity(PathMetadata metadata) {
        super(BaseUserEntity.class, metadata);
    }

}

