package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.Folder;
import java.util.List;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {

  List<Folder> findAllByUserAndNameIn(User user, List<String> folderNames);

  // select * from folder where user_id = ? and name in (?, ?, ?);
  // select * from folder where user_id = 1 and name in ('1', '2', '3');
  // 해석 :
  //    find -> select
  //    all  -> *
  //    folder where user_id =1 -> 1(user_id) 에 folder
  //    and name in -> folder 객체에 name 이 3가지가 있다.
  //    name은 -> ( '1', '2', '3' )


  List<Folder> findAllByUser(User user);

}
