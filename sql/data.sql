-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.13 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 xydb.sys_permissions 结构
CREATE TABLE IF NOT EXISTS `sys_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `available` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='权限';

-- 正在导出表  xydb.sys_permissions 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `sys_permissions` DISABLE KEYS */;
INSERT INTO `sys_permissions` (`id`, `permission`, `description`, `available`) VALUES
	(1, 'data:authbook', '电子授权书', 1),
	(3, 'learn:trainonline', '在线培训', 1),
	(4, 'learn:train', '现场培训', 1),
	(5, 'learn:database', '学习素材库', 1),
	(6, 'learn:conference', '高层会议', 1),
	(7, 'support:agent', '开发代理', 1),
	(8, 'support:returns', '退换货', 1),
	(9, 'support:freemail', '包邮', 1);
/*!40000 ALTER TABLE `sys_permissions` ENABLE KEYS */;

-- 导出  表 xydb.sys_roles 结构
CREATE TABLE IF NOT EXISTS `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `available` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色';

-- 正在导出表  xydb.sys_roles 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `sys_roles` DISABLE KEYS */;
INSERT INTO `sys_roles` (`id`, `role`, `description`, `available`) VALUES
	(1, 'tymlgw', '特约美丽顾问', 1),
	(2, 'ejdls', '二级代理商', 1),
	(3, 'yjdls', '一级代理商', 1),
	(4, 'qgzdls', '全国总代理商', 1),
	(5, 'zlhzhb', '战略合作伙伴', 1),
	(6, 'admin', '系统管理员', 1);
/*!40000 ALTER TABLE `sys_roles` ENABLE KEYS */;

-- 导出  表 xydb.sys_role_permission 结构
CREATE TABLE IF NOT EXISTS `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='角色权限';

-- 正在导出表  xydb.sys_role_permission 的数据：~43 rows (大约)
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`) VALUES
	(1, 1, 1),
	(2, 1, 3),
	(3, 1, 4),
	(4, 1, 5),
	(5, 1, 8),
	(6, 1, 9),
	(7, 2, 1),
	(8, 2, 3),
	(9, 2, 4),
	(10, 2, 5),
	(11, 2, 7),
	(12, 2, 8),
	(13, 2, 9),
	(14, 3, 1),
	(15, 3, 3),
	(16, 3, 4),
	(17, 3, 5),
	(18, 3, 7),
	(19, 3, 8),
	(20, 3, 9),
	(21, 4, 1),
	(22, 4, 3),
	(23, 4, 4),
	(24, 4, 5),
	(25, 4, 7),
	(26, 4, 8),
	(27, 4, 9),
	(28, 5, 1),
	(29, 5, 3),
	(30, 5, 4),
	(31, 5, 5),
	(32, 5, 6),
	(33, 5, 7),
	(34, 5, 8),
	(35, 5, 9),
	(36, 6, 1),
	(37, 6, 3),
	(38, 6, 4),
	(39, 6, 5),
	(40, 6, 6),
	(41, 6, 7),
	(42, 6, 8),
	(43, 6, 9);
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;

-- 导出  表 xydb.sys_users 结构
CREATE TABLE IF NOT EXISTS `sys_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `locked` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户';

-- 正在导出表  xydb.sys_users 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `sys_users` DISABLE KEYS */;
INSERT INTO `sys_users` (`id`, `username`, `password`, `salt`, `locked`) VALUES
	(1, 'David', '4297f44b13955235245b2497399d7a93', '123', 0),
	(2, 'Jet', '4297f44b13955235245b2497399d7a93', '123', 0),
	(3, 'Tom', '4297f44b13955235245b2497399d7a93', '123', 0),
	(4, 'Jetty', '4297f44b13955235245b2497399d7a93', '123', 0),
	(5, 'Mary', '4297f44b13955235245b2497399d7a93', '123', 0),
	(6, 'Shawn', '4297f44b13955235245b2497399d7a93', '123', 0);
/*!40000 ALTER TABLE `sys_users` ENABLE KEYS */;

-- 导出  表 xydb.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- 正在导出表  xydb.sys_user_role 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES
	(1, 1, 5),
	(2, 2, 4),
	(3, 3, 3),
	(4, 4, 2),
	(5, 5, 1),
	(6, 6, 6);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
