SELECT CASE WHEN MAX(NO) != 0
						THEN MAX(NO) + 1 
						ELSE 1 END
						AS ID
FROM BANNER WHERE BANNERCODE = '1302';

insert into banner
values (3, '1302', null, null, 'photo3.jpg', '139341', null, sysdate, null, '/stud/portalNotice?no=3');

commit;