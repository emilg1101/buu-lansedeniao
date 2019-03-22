package lansedeniao.data.mapper;

import lansedeniao.data.base.RowMapper;
import lansedeniao.data.entity.LikeDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LikeRowMapper implements RowMapper<LikeDto> {

    @Override
    public Optional<LikeDto> rowMap(ResultSet resultSet) throws SQLException {
        LikeDto likeDto = new LikeDto();
        likeDto.id = resultSet.getLong("id");
        return Optional.of(likeDto);
    }
}
